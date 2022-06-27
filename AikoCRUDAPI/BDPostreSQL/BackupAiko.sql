PGDMP     *    &    
            z            Aiko    10.19    14.1                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16458    Aiko    DATABASE     f   CREATE DATABASE "Aiko" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Portuguese_Brazil.1252';
    DROP DATABASE "Aiko";
                postgres    false            �            1259    16460 	   equipment    TABLE     v   CREATE TABLE public.equipment (
    id uuid NOT NULL,
    equipment_model_id uuid NOT NULL,
    name text NOT NULL
);
    DROP TABLE public.equipment;
       public            postgres    false            �            1259    16466    equipment_model    TABLE     V   CREATE TABLE public.equipment_model (
    id uuid NOT NULL,
    name text NOT NULL
);
 #   DROP TABLE public.equipment_model;
       public            postgres    false            �            1259    16472 %   equipment_model_state_hourly_earnings    TABLE     �   CREATE TABLE public.equipment_model_state_hourly_earnings (
    equipment_model_id uuid NOT NULL,
    equipment_state_id uuid NOT NULL,
    value real NOT NULL
);
 9   DROP TABLE public.equipment_model_state_hourly_earnings;
       public            postgres    false            �            1259    16475    equipment_position_history    TABLE     �   CREATE TABLE public.equipment_position_history (
    equipment_id uuid NOT NULL,
    date timestamp without time zone NOT NULL,
    lat real NOT NULL,
    lon real NOT NULL
);
 .   DROP TABLE public.equipment_position_history;
       public            postgres    false            �            1259    16478    equipment_state    TABLE     o   CREATE TABLE public.equipment_state (
    id uuid NOT NULL,
    name text NOT NULL,
    color text NOT NULL
);
 #   DROP TABLE public.equipment_state;
       public            postgres    false            �            1259    16484    equipment_state_history    TABLE     �   CREATE TABLE public.equipment_state_history (
    equipment_id uuid NOT NULL,
    date timestamp without time zone NOT NULL,
    equipment_state_id uuid NOT NULL
);
 +   DROP TABLE public.equipment_state_history;
       public            postgres    false                      0    16460 	   equipment 
   TABLE DATA           A   COPY public.equipment (id, equipment_model_id, name) FROM stdin;
    public          postgres    false    196   ,       	          0    16466    equipment_model 
   TABLE DATA           3   COPY public.equipment_model (id, name) FROM stdin;
    public          postgres    false    197   �       
          0    16472 %   equipment_model_state_hourly_earnings 
   TABLE DATA           n   COPY public.equipment_model_state_hourly_earnings (equipment_model_id, equipment_state_id, value) FROM stdin;
    public          postgres    false    198   :                  0    16475    equipment_position_history 
   TABLE DATA           R   COPY public.equipment_position_history (equipment_id, date, lat, lon) FROM stdin;
    public          postgres    false    199   
!                 0    16478    equipment_state 
   TABLE DATA           :   COPY public.equipment_state (id, name, color) FROM stdin;
    public          postgres    false    200   JG                 0    16484    equipment_state_history 
   TABLE DATA           Y   COPY public.equipment_state_history (equipment_id, date, equipment_state_id) FROM stdin;
    public          postgres    false    201   �G       �
           2606    16488 $   equipment_model equipment_model_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.equipment_model
    ADD CONSTRAINT equipment_model_pkey PRIMARY KEY (id);
 N   ALTER TABLE ONLY public.equipment_model DROP CONSTRAINT equipment_model_pkey;
       public            postgres    false    197            �
           2606    16490    equipment equipment_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.equipment
    ADD CONSTRAINT equipment_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.equipment DROP CONSTRAINT equipment_pkey;
       public            postgres    false    196            �
           2606    16492 $   equipment_state equipment_state_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.equipment_state
    ADD CONSTRAINT equipment_state_pkey PRIMARY KEY (id);
 N   ALTER TABLE ONLY public.equipment_state DROP CONSTRAINT equipment_state_pkey;
       public            postgres    false    200            �
           2606    16493 '   equipment_position_history fk_equipment    FK CONSTRAINT     �   ALTER TABLE ONLY public.equipment_position_history
    ADD CONSTRAINT fk_equipment FOREIGN KEY (equipment_id) REFERENCES public.equipment(id);
 Q   ALTER TABLE ONLY public.equipment_position_history DROP CONSTRAINT fk_equipment;
       public          postgres    false    2692    196    199            �
           2606    16498 $   equipment_state_history fk_equipment    FK CONSTRAINT     �   ALTER TABLE ONLY public.equipment_state_history
    ADD CONSTRAINT fk_equipment FOREIGN KEY (equipment_id) REFERENCES public.equipment(id);
 N   ALTER TABLE ONLY public.equipment_state_history DROP CONSTRAINT fk_equipment;
       public          postgres    false    201    2692    196            �
           2606    16503 8   equipment_model_state_hourly_earnings fk_equipment_model    FK CONSTRAINT     �   ALTER TABLE ONLY public.equipment_model_state_hourly_earnings
    ADD CONSTRAINT fk_equipment_model FOREIGN KEY (equipment_model_id) REFERENCES public.equipment_model(id);
 b   ALTER TABLE ONLY public.equipment_model_state_hourly_earnings DROP CONSTRAINT fk_equipment_model;
       public          postgres    false    2694    197    198            �
           2606    16508    equipment fk_equipment_model    FK CONSTRAINT     �   ALTER TABLE ONLY public.equipment
    ADD CONSTRAINT fk_equipment_model FOREIGN KEY (equipment_model_id) REFERENCES public.equipment_model(id);
 F   ALTER TABLE ONLY public.equipment DROP CONSTRAINT fk_equipment_model;
       public          postgres    false    2694    196    197            �
           2606    16513 8   equipment_model_state_hourly_earnings fk_equipment_state    FK CONSTRAINT     �   ALTER TABLE ONLY public.equipment_model_state_hourly_earnings
    ADD CONSTRAINT fk_equipment_state FOREIGN KEY (equipment_state_id) REFERENCES public.equipment_state(id);
 b   ALTER TABLE ONLY public.equipment_model_state_hourly_earnings DROP CONSTRAINT fk_equipment_state;
       public          postgres    false    2696    200    198            �
           2606    16518 *   equipment_state_history fk_equipment_state    FK CONSTRAINT     �   ALTER TABLE ONLY public.equipment_state_history
    ADD CONSTRAINT fk_equipment_state FOREIGN KEY (equipment_state_id) REFERENCES public.equipment_state(id);
 T   ALTER TABLE ONLY public.equipment_state_history DROP CONSTRAINT fk_equipment_state;
       public          postgres    false    201    2696    200               a  x���9U1E럽�C����hl'F4����x���yw��|Ar\�����������2҉P��$Ё�R�{�|}��wl��� gl�	�=�X���	�y��p �2��b�=AD���ls<!r�CDq:�f��<�:"y�&����$�R�ޠB��Ն�R�^&��ڍ�Ap`�Da$s����/� �=�2���K�eV�沼�M}�d�'DjQ��s�	����0�1���|i��]/�#TAf�;���ƨ�����ї�[�Q���D��ɖ�z�"��dt�i���	��!��5�>���ȍ���z�c�x2jF����9�Տ���?����}��Z�$���      	   �   x����0�:�"��l%A5A�m�@�9�`�,�{ȓĔJ=6�<'҉�ԅ�t��	������X�7H��YՎ$<1���b�P�t�}��?��[�5[��(�$̍4�Xs�R�Yu8����������.�      
   �   x�����!�c.�D�\����������~�D��
|�������P�Z7�E6Ȑ���c�:M�tΡ!���V��jLC�>җ��`�`��Ȅ�W<5c��1&�=1�����M$;�*q�$���
C��Z(U�J��~ S�����kG'�Z�a�ЪX)�=���Z����            x��}I�9�츴���-#@��[˟�����\"$�T\�H�+ψ 8��������~������Ǟ�>����?���k�G��Gӏ&������|����������n������P�i7��o�j�o ǟO8e�)��f�i8�?Ἱ����{�������C���^f$������ ���;>"��>��Tω��}������'l���~����y���_/��˚�/��V��R��ʜ���:����T�,}$~A�m������?! ן_�p�v�|�ه5V
�Y�	�:�7p.���?m���ç�w��ل��p�j��(	�h�K3h[�6?�(n3	8�MnͷUcЅ�ś��]oA��s�T+��2/��SR�7���'\����M��4�+�!�^W��F��k	+ث��B�ϣ��س�Ox}öqO{�d��6Pk5�lYgu�*j�>�P��-�9����BM7����8�s&`���+ww��g/��b�����0��{_��\_��Ѯ>��$��^4�����pʤ2�.�/2.���A5�����#��F��{�\��-�.�
�
������].M�[�ܶ��ayR �ɭ��j��z ��� �����mC�m�C��w�G׸���`�b���'T��a�؊��պ��s�A� ��ɂ��ü��",��L�>�0ص���3��5��qXCw�do�����Y��P����1����vwl@���s�Bd�7Y��#�q���������c�4D�O8˭S��d�����,߰X��
u�A�ʺ��O*�o,q�U�:�2��P9$I�]T+��qAq<�%qw���y����K�o{,-nF1>�`Od��T_z�a�Y���V�MT,���H!��Z�O}�����\�	�y��v:y봐8q������YS@�뒝�:�I�V�?`�ۇ�cI���G,7�T�xz�cc]ZH��H�p�POn����Q37����~�>&��	>L�"�*��'�`�w������LC~X!�E�wxw�hd��~B+�.[�M�����u�x]cQ��8�Ɩ�y�?Yp(k�CZ炇�^<��1MP�#��iNԋ�x0���������7lF����X{x�E�-����$�>�Q��hZ�����tw��5�}�y�I�eG�۝}�Y�?De�v��HZ94���L �.,�.�1��R=�o�"���=�?����c�ǂ��o�~���}}���Ә��sƭ�����6�ȋl�,x]d��͖��5A�H@-�$\�1F�۶�M�O��?���'.
	���6lR�i�ԟ�l��!���	�)x��:��h��T��K�(������6�K�Ŏ���g��ng��-�<�x�5X),�Z�{�q�����R�%1ѡE$��>-+������'�r��<޺.�͌>v���4q�����̈�x��m }��"��
aI>Ev��Pa�!"��*a���L.���z��S�CŰ�{&��W(�s�`��4`)=��ۙT�H�i	�tp��=7��Ԩ��G�WW��LvQ5
���=��=�F��0���<���2�L�uQ~�v�`��"�K�K��E�Ԯ�:�xܺ9�]K�r$&�C�Om=�ZqQ��k ^r�D,aA��HL��z�<�.ؓɞr�oJ��hr׾{�Vr1������w��)[���:&�IY+���� ^�68Tƾ����SQ���e/��2��,VhF��c�!3P�<޼�!��y_\i9��Ȣf��ɑF!gQ�pI�8�_��ʳ�2DF�<7L�_<���}�Ʉ�i�k���^��e��_��[1@לt����73�Ç�'tٴb�+�W�݁C��=�,b���P�!�����xE	d��X���8��Lv����+�\�"�q�@���
+Sn��H߼]#�+k`lX�]Y�[�zkͳbŖ�bX����e�����KjV��s���X�Kj���N�/�X�;���=���U�<�[���3�#Z�I������m��_K1s��u�lXy�L��a<�潛c;�	kxj�Zy�:D���0Mx��(p�\��ȑ��x�iFk�?��i��#���>;�(�'�{|�:�5*���%�'�&,Q�����e��L�������#
0H@/Wyf m�cA��R)y��!a5ø�¸'�)��ZH������a5[ ������G��]Ho�}�Rz�f���kZ�ef��u;�D���w�HV�4'a]��7����4�w�����X��"��+�����wl���p�g�/V�t~>��]���R�\�	����iaߊ>[0�,=�P�<�U,�5��3�#���9���×�b�7��C���hE5�}���k��޵S:�Sm����o)T������rm�_x��d�{���Ϯ�N�	7\2�����e�X��7ي�ج�|>����e4ॼ4;�B�:����+a.^f.��J�o�%#'��<�P�W.=P���}d����/�f��ʌ�A���� G)���8�DT�:x�r���P#oľ�b�7N��<
�y��P(uK�����W�#�;`���W�0����_��c:-�%���Hb3�|�}�U��lYX	"��/ �����N�)c�R���w;��P�V6��w����z�8	X�q%�5	�Gh��=����(�ڤ�D�����M=D���R��0*�pY$����X��ɶa�R�5m4�%��J&+���KtE^I�cCAkf'���`��BC��,Sz˻��ZZy�y�M�B��'���kqӀ���;�tx�Ȼр�6�MZ�k7.5+6�zA�����5�$`�����<�Pz�Ӏwx�m��7Wy��̸�G���0(,�~e=<���Ї\�!xˈ���(B_�Q���Gϊ\�F��`it[rz��9#���rƾ3\��JA��|�L'���$�fM�n�+��ߓU��-Z?m=�A�%�x�h����ƺ<�'k��v��5y庪'?G�d����.��R
ݣ���5��琤I�	�*���7=���Č���s�	��%��h���B����>�&�0�Z��������kk���?��Cl��N�J�.b��ޜ�5���OyDV����x"�2|�O�� {������b� ׬���P�8$��ŰTI�x�ֳ���u�j_��=���aL
Y����A*A�ҭ��Y����;8�΋�{����Fk�bi��*����؅�46ʧ��JF���Cu�RS��8�ar2-5�"Kb@����Q$�(��*a��JKM��X��Q���`�f��b��F|>!�릿a��7�G��ڠ_�md���:��d��u�yV*�t��D��Y��u��;+��0����D�m�A��Ȉ�F��P��?������_�~@��û�����A�/�� 0WQzA���,'E�5�i���B��"*���|�m�sfed(��`?Ң�����w�@ރ�xZ
FV������g�z��y�?\��Y+�|�n�=�^��x�;N\���K{�U4�!�������7��� �M�c��h�[�8ހ/V��V�5N�H��G������L���v���M���DH��Nr���`v�Y3bx��-��O�E'+{O��@��!�P;�E����g���0�H���}��z��kh��JcB3�/\&�Dm�Q1����Y�0�&��͡$&+�e_|4��E�u���
�u�sƺ'��V� �������_Y�"�h_��冔�x�9&����N��w����gIQLi#Ϥ����Q`O���pHT^�,��#(	(����5�$:x�(t�z5���o��!V��!z�Ii�ۄ@�սic��J��C22��,��Z�ڣ7>����v�Sm�ԃ��%: �ןI.�5QF�� �0���?ž��zC��i��kC�ߚyf?�!K����U�����{�<�$<���*n����~�q�(lxȿ'�n���y�����N-+�eȇ�~�����~�ږm��^����    K�͆q��)o��K���{:ݜ��$��,�u�+�T��}��>�.&e��cE��.�[�*�0��p�6iE#KqOlИ��VtF��,T)�C21e�~Ú�h����sܔ6)Z#6�~J��ëo���,E�H*��j��o�Sy��gL��*��ȹ+{��5��j�v����c��\v�y��g���um�ƍ���k��wD�o�a�:WyD�>����~��+�k��W�M�.O7�n1��,�מ-��+K���ْ�������F/�on�
+��)�	��e�~M/et�O�ާ����X� �7G��5�3Gjƚ�!���������2%��)̂�7����=[F`��`��fֈ�0�5-18���[o�����6GR���Wh�t�L��n��fy�����1ˆ���_q{Ψ���$�[G��:}~;֠lV1���P/��,j�	��7Z��=�|H���_l˷��������}]�J�k���ێ ſ�d���&l�w_;�OZ>Z>�X���'�1�}�3F5ӀzB߱�=bÓ��f��O�լ-\�����	��|͆� kڨ�f�F��������T����Y	hE�q�<�ք����~w�j��z������#;���|�2�o$ih�C
��b�]�ߢ�.'e��'4�݈.�A�3Ո�'�j�Dt�?�u �BX:v�@R�I��|&�E�QS1����ЀW�+�Ʒ��Y��5u9�@e:&��k~ B[�3YB���	u���&��2�J<mo�����p���/���/X#+jO�~�,���������8;sL84`�6�	3D����NʔyP���1\���R����޳���G��E��.jPh�ìq�f'�&<^��>��=!���;�R*W��M
v]�A�#�(WB��{� c�))�xO��ڧ�?ˊM/��?g!�lZ���> F�%���}�o����:�Ě����[�'�\s����g╹Ƅ��P��j�'��.^7od�Ć5�F���R��9e8ݱ����}[���{�b3J�l��3b �	GM��Tì�QsҢԡ|-�t��}���Omύ�x�����i�HH0C��g����$�E�d7�y�}A�I�s2$�zt p���U&@Nr��c4���@��j�'H�ƫ���l+�㽊_Y�Pv �fc�������1P���KW��� R�4ॼb�i�P��HP�D����4}�f�� �t�6�)�+�9�b���C��eDn�f�<�v�b�pZ����n�?�� �RC�zM��g���B�?�����{�5�ԣ�3�����N����3Yl�i�D�Z�Х�1惴�ueP��A�L|}Mz-WM����IZ�|�29�{Eo(�6�lk=t��}B{sy�'��(Kk��d�IÞ3TK����y�ِ�]�`׈��Aɦ�ԍ}�Z4� 6IC<f���y�Q��s�ܑA��A��[�WH%��e���EHx�s����L&�fH�����^�	�'�)�6���h>̺�Q�<��	�E���F��x²� f��֌uʴR9�^�)�RJ��ٞĥE�җI�_߿}��s~����c��?���o��޿�k�5y7
Ha�F�]#36x���!�W��kT}��j�ũЀe��=e6\��46���fL�$�j�hh�9�dD�zӀ���)���[�Ԕ��c�<=��^��8���Xa�sQ/�/�nX�K{������kd���ضb�x�Ƀ5�'u���q��6q�w[4�=Eo���Ӈ+ao^�Cy� rwaT]��RL���k�)��w�,����� ip����Q�t�˯e�̛.ќz�?+�e*X���Ć��cZ���}ƵkDc���$���'�[~4zF,Wۡ��ᾧ6�����ॼ@�ٰ���s�e�<x�����/ � ��Eh���l �S�������W�4QR�y�Kw�r�l^'�rde�:��3�0λ�bSz��k�Y��e4��b�G�4��{(V��J����o3��W��}�3n~A��ʡ�^�W-G�DO�˸1�(y�^෋U�2*f�ԎU��%�7��ٶQ�ޔ2�TU��_'1k��|�ל��{mpR��e1��Yz7f,%K�"��(6?6� �`�y^A�2�9�Ir� ��!���ʞ��,�u��6pM�MyX֌ֱ�;�%��9Cޛ�M�{���C��4&���6�����S��6}e]d��H�����{?E@-R�,�=�u,yʀ�RE-X�%���$�9:���ֶ�6�{�tZl"&~��X��L���+���՞��pLMI���bQ}��!K��mI`w��#�a ^�F�~�@��Ѯh��/�ӫ�#�����Mw�͎�s�*���ݟ���e���E��]4'}�K���`	��8�g�kK�_ ���FE���������$>��fuC�6�M���|){���X��]
#��ʵ�5�W��߯�.<�%63&���ع�ޔ2K�G�����Th�]b"�)1[�p%��*�R�u:�����L�.���]�j�X��*�:">�I�!�
#��|�/���c��?>��p��׺�a-
��-l+�F�
��N�������c�Wĸm}f�����Zۃ��&��_[�Y�;�j�Y=<	_o�������"��P���Za�!u0��:�,S��nFӰ�,`����֟�hl@c_�&桪[�� P��?�����z�*����,v�!�WG@�lp�-��f�����k�b�L�sk�M���� vE�{�eHE4�XF@�b$>x�l�Y*��7��R��#6=q�xe	����-��1,�\e�BL�IW�����؀�z��l�Ł�ҀweV̎�O��Cgy��+sH����L<x�z2�-Q�^VPZ��^v}e�cEM<x+��q�3	XS�=��?�M<0y(�[V"T��h��"�Pj���d��:yQj�G�H� 1�v�o\�e���̾�h�A��ԙ12����k�;l-Z�1��o�'��M�=A9s�!p`��^�$�<D���y�{;�����j�Pdw�3�#�@�m�Q;��kG��ī�a��
�`�i��L�y=��c�1xo0鮏{�q�R3�P8��!0�d�a�%!6iCmvgg��Sw*�-�2���\�I����dRǊ��4����)���0&�e���j�i�R�:¸b�X�$e9���70�7Z+��?;ݠX�P���ԸٓH�ɻ�������xu������+4��g�1ݑ,���a��<`�C�Ž`�~x�xl�"-�������LeDCxv���I�6��4��7��ܛ��5�,�ޞ�v���I���\�t�J,>��Zy�(�M�#�9X@+��H�e�d��ۢ��!*߯��4�kF��CA&�3��{w9f\�6��Α����f� ����u���Ṷe��7�f��Ө��X��e�-�!�Q�6�^Y �q9���*/x����bG�3"�F��sH��e�*R,oк��ύ,m�՛����s(�kG���`��ϩ���	�>ae6�cڼ�/�˷��뷯����5?̾����||�.��������=�?������2x{�{7y�ۊw,�]�CK��3�����Zs���ckx��c��=�"�L�4$yF���+�=�9��W�/��2�:��A��c4�]�AC���/�K Ww>�����e��K�k�nJV�?k,g���;��lE���\+'���}�,���+}l������z���[�!�4�])�UZ:��Z�Jκ�-�g�Њ�/	��M�yf�B�,������;���Y��f���6��Wu�,J�<��=)���d����M��Q�įg3
(�({Qj�ðhIW. �ʻ2���X(�D'_��(�kJ;�l��ƻ�hs��z;+kx�<z���h� J]����� Ј?Ҁ�!w�lRWX����-1y�aZ�b-^mS���K<+�@�I��+�'>[e�r;R�ל�koY��9��|��<Y�F�䷵� &  pkG.�v���$`%J���}I;f{Q����Ik^{�8</����z�'�@l�z],�1h&����$��%�9�M����Ia�H��J�!K N�>k%G��Y���:��e�+�E��\�^�e5�"7�����	7Q�k�h�	k%�x��N5K��K��~�83��5�hǳ7�A�k�t{�yY`��~����ǟ�pߴ(G��F?+��X�9�`�nec1@*]y�,�|K)�m\�<���zZ*��̜�78�4�-���p�n�z������P�xm7� �Nm��oY`�;�JMmːP%�\pV�4 u�y���o���X@)�|�l��c���!��g���� 4`IQ�b룼"��Z�:��յ����9H��&��ּ��px��!b��֮��i��6�����u��'�����e�Z	R�����x���[�GR'X�O��Bh�ޔ|��̕��`5�x��H��W`	+ե���Ѿ�5�l��*u1�c[�d*Q���a�aֳ`3��(��k]�kL �O�J�{2��c'�T��]�-&�}��S��O¯��m|��}���#�g>�͟�����]r�t����_y���X��>�� ����l��Fm XV���,C�8o���t~��,Z�h���
lвcp�]9��7�`�r��I5Ҁ���Q8�R���,&ԛ?�FS���SA�l�_�H�Uy���n�]4�]k����lpKi�;4 ��2j���bϤ4=���d=2ޱ�,��V�8��7.	X�/A?G���k��Ѐ%z�5�}4P�-CSܟ��X�5 ���촗�`߸$z$�s�j��lVkBaBjR�F���7y]�%Q�����;�r�K��`��$(�L@w>���^�����r�4V
w퓔����!�꾌�_��C�
�A
MMP�"�=r�$6��'3LJrx��i�;\/���6�["�œRY�Lđ0�=�O����W�/�W��h���ZL�� {�8���� ��o6���hI��i){9e
g����QC{�hDr�
X�Fw|�d��p��M�5�tqM�O�3;w�Mj<���F��*9���$`m�"�3��֣��߭�%s����7Uv[Ϙ:���$`M��؟pz(�G���U�Az<�X��68*v;'`p������H��j���d)3�c���=� �g�k��H_��|�U(mºPRKC�}�dx��۵���<�.&�р��3���=FTЀw�i$d���Lj���h��<��Y���&�{OZcCb�:�W(�5�i�Y�3Cޓ�`=���/�����kr�U���vx�Ѷ���X�H��>����cr�j5��L��M޺Hǔ�6��w����4�M�:xa����c?a!I1�r>���}e+���h�	EC�Iݮ'3F�\#v[p�^�	�g]�����M���3����'�(� ԙ�1אu&�S�T-(�
K5)�����r������џ�{�����@���)4lQ2G���6Z?*"9?����N�����������/_��=[�         �   x�λ1E��n�X�?��-��Hd[
�P�6��ߙwΈ�`�o�0�2i��(�O�e��;%흢ob�g`\[��i�j�07�"��d����1����XAs���	x�Rj��R5���|�t�㳤�
��~��� �.X            x���I�9ץS�D#��,����G�`U�~$P�:�JH�><:o�Q�랶򮯭��m�V��3����L��G쑶=�=}����~��c��x�ҶW>�My����ۭ��ޯ[{���������{���Q^���{�F/��������������SU��?��c���V��,�ܶ1������6�Y;��W�=����}zv��P-�=���=�f�����W�_�=��2�+��TOs����b�=�gSUw������A����|����N����N ؽ��7��>̱��vW��~:����^M�݇j��}zc��|��>3U�c~{z׏=����i�9�I��/��a���	vW#�E��eDO/�"ya�~��^��e��#z��0}��O���vϧ���c/�Q�`�b�݋(�yj3��wt ��~�Ha���Y��{d��ac?E�����'0ƞ�x5�Vc���|���=D_l��}��}��4ͼX�ft��^��R$�[:�b4|��zS�)���	3��S�R��X;�l�]{W�Z�<�b%.��u[t�2E]M���D13�QM�㠋�A/Ǳ�eڷ��4�lj�y1��͌�(�=�TETƞ��A7}�����A���3Op�Y8=�k�T��#�|��|e�# �߯�gz��?�#i옎�N�,ۉ�e��\?v{P:�g(�y����^�������(��贪���Z-'�z�TX_�t�a:��)���1]��Lǁ�(�`�uz�n~զ~�3��.��C=���P:�7a��G��0��贚��H��(O@�Lǁ�K��rz��Ei7��EG�wL�N��L_,�*q�e�
F�2ߵa�2L����w�1�t���P^o�l�|)�9�����i�ӽsu�#ŵZa���Ǣ�>AU��NZ��-�`��ŝ��_��t�t/�����Z��1]���j����뫘.�|��Ϝu��|�����
(����E�v`�K�to�\t/*[�Wo��)O��ݛ�A�b�:�Ś|������A�-a���:+����j���t�\�PWS�7�(��#���[jcq�S%�̺���贛��vW�
X)M��0�J4u�f4ݬ�.���]jc/���^�|)v�ZY�z�����,����G|������1�V��[����?�i옎v1LGy1Jg��Q��U�0
��<�̋Q:�����	x���D�挤q���3�3O���=JLGyF�:lL�j������S��M��4��t�6X�����2v�c�՗�.����M��Tc:��0ū�>�mALG�Jg�NJ��D����E�i��(��|B�;%��j��32L��Ke��c��Gb�1�{gS�o�P��,����
�QR:����U���<�S5��Ta�GFo�l��Do�2:U�R��tX�f��3�.~ա�H���T�⌜��i7VJ3�i�^Q��t�^�fi;=˜U����SL���H��)���=��L������ݵ��/������V�l��K�Ee�^��e�>����f�#��죓�2vqFVu5��h�W��d)����t/�jti;E��vI����>W��Ee1ԳI��y��gD<��mO������Q.[�5=������R:����#��[���!z����n�=������)H���=�_5�^Q��"JF/�S	�����-MD���&��.Z���q@������ٍjD?�׏w��t�����/H����_�C�����}�7(]<��z��b���M�2-�����o�z�͘/��W��;�R_���{;p��4)]��R2}ॾ�=��*"���)L_,�鋥���)݋�:�a3z�=� �{Q�^h�2J�2���G����y`J�|������j����s�ѮB�.���J�No:R�9��k��>�Ӄ��(v��t���Z��ZL�����P���n��.��s�Ta�Ɍ�"�����P�ڑԵf�lѽZ����)�\jЎH�.�g�jca��`�t���:ɊkU��G�]A!��#+}�ҽ�)*��	�朩�Yi�KH7��F��R���t3/v�S+X��w)]��z�u3��t�^�}VJc��C�XZt�2L�Pf�ϑ�۬�����,q�?�O�Ϩe�}6���0���
��x��N@�,����&LG���_5`U��ݯ��&F�P�����u�,0�����Q`M�Q����j�t�[�t��e��L-�`�Q�A����}��)�e�1]�8�뮌>`4L������>U?r���T��4���a{�Ǉ�r����2Ɍ�];�q`��&�	�E�g��^t/�=v1�^)]��?��^�U��3�NՌ��z`����S�9lJc��׏���*�����y��`}��՘�1�˿'�	���4�h�f�����/�3]*�{��R�zsf�=O�1�[�A�\Q��G��"L������=�y��fbѽ�؇������^ӑ����� ��[J3�����݋,�8g*|W���]L�<�ի1v�ӣ=�0]��T������`gF�P]���I�Ƙ.����UL�r�A��a�W���zzj�|�e�����b}�<s���}��Տ!��6���ȷyo����}�1�#���9��h��ttjc::�)��D�v��t��q0:�aJ�	e�1yK�^`�>LG��3�:��3�����f!(�e;1]�{�/�`�xj�^H�jS���8LW��r�.����#���9���*��;�Tw`�9�ҙ�ї��{��[L�����_��3�'�!�tV��t�2,���HO��6L�bd�����NkÔ����yKKS�e�ν�����.�������H���^t�{c����:��x553�Y�]��u>LG!JgwU0]��T���H���e��O3�_tя�P����A_)B���9���.���^��ܗY{��}L��{�Р��0i�0���#`0LW-#�0�g��Xt/O���ީ������uΨ�pл��n~զ���#1]���X�����}�ӽ���S��]��]�R�����E��j�[9���8���|m3���?���Y�Vk�kke/e��rӑ/F����t�!g�]�1EÔ���c:�()�u��tq���&����Ժa:�<S:��0]�#id���."�3-���;��vo���mAJg>0���LS��뫘��wJg:lJgF��QJg�+LO�	+Ϙ.z���QLG�2D_�KoK��QLG�+F��KL��{��y0���S�
FFطӽ<A��]b���=�9�����=� ўE�δ��.�ME��TSK��M�2z5sz���ޣ�t�K�t��h�+������5J���|���|��f/��3��]�>�ZY�7L)�\�ì�-Ů�U��V�0����їb׋�c7ke���bK��M]��������,��u�������#L�cѽ�R�������g�����}�������b���E��NL�N�_�t���=J7Om��*��>��.�3���Z5���z�����ݯ���o��m߷��}+�o��N���Z������z�t���t���t���t��Q:�*���%Jg�<��؃�3<W1E����.�����;��bmL����NcL�{U�L���1]�	h��Y��ű�J���vWO���Nu��.�|�_*���|�اzj��3�δ?����z�ǹ��s�܍U���=�GJPI��G���ݓjw�1d�YfLGCL����e�l�|�V�0]���<��{�*�����t1��������G.�8�+��c�8ߩ�ӽ�~�f���Ҙ��l�7��&O��."�wu�v�V�t�v3N��tq��=ԯ:�=LGumL��bI͋%�����*�2#:�m��^v�=�#v3�j��C)}�eԼX��%���t/*��n���D��5�t1�j~f���fP�ިftz��=?2�:g���W��	ӽ�&��a/�W5?�߅�7��M�L3�.�|]���Y��"0��k��{d7sث��W;�{c�x��\U��1��sxW���[�ҁ{��Vڽms������y�E��Lc��hFR:�B`:�3�N_��t�q`�j֧���Քa%�Q~�ŵ�a$���{�׏��{d j  �UJg�wLGy`Jg�;�W�ӣt��f�o�c�:v�1�t��h����F�n��U"�N���.�}��؄�2J��R�{vO���,�;�����0�g(�)���1]�}�ѳ��6��2����fj1��)��R1�;=R�CJO�Ԡ�Ũw�e�nf�R7c���]��6��gӀ��1݋��r��Ŝޢ{9�s�]a�L�u�tt'��E˜��^?�E�v1�/ӽ�Rл��.���_et5n
z��Eoii��Ld�[
5*[*@q�E��E�LQ��fE��Ŭ����^$�4�^bѽxu)����L4ح���=��k�C5��{dW�H�Vj�]�䃾	C�Z�)��FC��?����ǟ˷1�     